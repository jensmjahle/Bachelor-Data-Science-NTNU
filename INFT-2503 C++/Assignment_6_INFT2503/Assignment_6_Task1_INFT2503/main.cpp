#include <iostream>
#include <memory>
#include <vector>
#include <string>

#include "ChessBoardPrint.h"
#include "ChessBoard.h"


using namespace std;


int main() {
  ChessBoard board;
  ChessBoardPrint print(board);
  ChessBoard::MoveStatus result;

  board.squares[4][0] = make_unique<ChessBoard::King>(ChessBoard::Color::WHITE);
  board.squares[1][0] = make_unique<ChessBoard::Knight>(ChessBoard::Color::WHITE);
  board.squares[6][0] = make_unique<ChessBoard::Knight>(ChessBoard::Color::WHITE);

  board.squares[4][7] = make_unique<ChessBoard::King>(ChessBoard::Color::BLACK);
  board.squares[1][7] = make_unique<ChessBoard::Knight>(ChessBoard::Color::BLACK);
  board.squares[6][7] = make_unique<ChessBoard::Knight>(ChessBoard::Color::BLACK);


  print.print_board();

  cout << "Invalid moves:" << endl;
  result = board.move_piece("e3", "e2");
  print.print_move("e3", "e2", result);

  result = board.move_piece("e1", "e3");
  print.print_move("e1", "e3", result);

  result = board.move_piece("b1", "b2");
  print.print_move("b1", "b2", result);

  cout << endl;

  cout << "A simulated game:" << endl;
  result = board.move_piece("e1", "e2");
  print.print_move("e1", "e2", result);
  print.print_board();

  result = board.move_piece("g8", "h6");
  print.print_move("g8", "h6", result);
  print.print_board();

  result = board.move_piece("b1", "c3");
  print.print_move("b1", "c3", result);
  print.print_board();

  result = board.move_piece("h6", "g8");
  print.print_move("h6", "g8", result);
  print.print_board();

  result = board.move_piece("c3", "d5");
  print.print_move("c3", "d5", result);
  print.print_board();

  result = board.move_piece("g8", "h6");
  print.print_move("g8", "h6", result);
  print.print_board();

  result = board.move_piece("d5", "f6");
  print.print_move("d5", "f6", result);
  print.print_board();

  result = board.move_piece("h6", "g8");
  print.print_move("h6", "g8", result);
  print.print_board();

  result = board.move_piece("f6", "e8");
  print.print_move("f6", "e8", result);

}
