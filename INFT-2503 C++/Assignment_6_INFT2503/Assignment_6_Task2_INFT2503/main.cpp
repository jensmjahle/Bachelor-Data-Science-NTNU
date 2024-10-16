#include <boost/asio.hpp>
#include <iostream>
#include <memory>
#include <sstream>

using namespace std;
using namespace boost::asio::ip;

class WebServer {
private:
  class Connection {
  public:
    tcp::socket socket;
    Connection(boost::asio::io_service &io_service) : socket(io_service) {}
  };

  boost::asio::io_service io_service;
  tcp::endpoint endpoint;
  tcp::acceptor acceptor;

  void handle_request(shared_ptr<Connection> connection) {
    auto read_buffer = make_shared<boost::asio::streambuf>();

    // Read the client request (until a newline "\r\n\r\n")
    async_read_until(connection->socket, *read_buffer, "\r\n\r\n",
      [this, connection, read_buffer](const boost::system::error_code &ec, size_t) {
      if (!ec) {
        // Retrieve the request from the client
        istream read_stream(read_buffer.get());
        string request;
        getline(read_stream, request);
        cout << "Request: " << request << endl;

        // Prepare response based on the GET request
        string response;
        if (request.find("GET / HTTP/1.1") != string::npos) {
          response = "HTTP/1.1 200 OK\r\nContent-Type: text/plain\r\n\r\nDette er hovedsiden\n";
        } else if (request.find("GET /en_side HTTP/1.1") != string::npos) {
          response = "HTTP/1.1 200 OK\r\nContent-Type: text/plain\r\n\r\nDette er en side\n";
        } else {
          response = "HTTP/1.1 404 Not Found\r\nContent-Type: text/plain\r\n\r\n404 Not Found\n";
        }

        // Write the response back to the client
        async_write(connection->socket, boost::asio::buffer(response),
          [this, connection](const boost::system::error_code &ec, size_t) {
          if (!ec) {
            // Close the connection after the response is sent
            connection->socket.shutdown(tcp::socket::shutdown_both);
            connection->socket.close();
          }
        });
      }
    });
  }

  void accept() {
    auto connection = make_shared<Connection>(io_service);

    // Accept a new connection and then handle the request
    acceptor.async_accept(connection->socket, [this, connection](const boost::system::error_code &ec) {
      if (!ec) {
        handle_request(connection);
      }
      // Continue accepting new connections
      accept();
    });
  }

public:
  WebServer() : endpoint(tcp::v4(), 8080), acceptor(io_service, endpoint) {}
  
  void start() {
    accept();
    io_service.run();
  }
};

int main() {
  WebServer web_server;
  cout << "Starting web server at http://localhost:8080" << endl;
  web_server.start();
}
