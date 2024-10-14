#ifndef CHESSBOARD_H
#define CHESSBOARD_H

#include <iostream>
#include <memory>
#include <vector>
#include <string>

class ChessBoard {
public:
    enum class Color { WHITE, BLACK };
    enum MoveStatus {
        SUCCESS = 1,
        INVALID_MOVE = 2,
        NO_PIECE = 3,
        WHITE_WIN = 4,
        BLACK_WIN = 5,
    };


    class Piece {
    public:
        Piece(Color color) : color(color) {}
        virtual ~Piece() {}

        Color color;
        std::string color_string() const {
            return (color == Color::WHITE) ? "white" : "black";
        }

        virtual std::string type() const = 0;
        virtual bool valid_move(int from_x, int from_y, int to_x, int to_y) const = 0;
        virtual char piece_representation() const = 0;
    };

    class King : public Piece {
    public:
        King(Color color) : Piece(color) {}
        std::string type() const override {
            return color_string() + " king";
        }

        bool valid_move(int from_x, int from_y, int to_x, int to_y) const override {
            return abs(from_x - to_x) <= 1 && abs(from_y - to_y) <= 1;
        }

        char piece_representation() const override {
            return color == Color::WHITE ? 'K' : 'k';
        }
    };

    class Knight : public Piece {
    public:

        Knight(Color color) : Piece(color) {}
        std::string type() const override {
            return color_string() + " knight";
        }

        bool valid_move(int from_x, int from_y, int to_x, int to_y) const override {
            return (abs(from_x - to_x) == 2 && abs(from_y - to_y) == 1) ||
                   (abs(from_x - to_x) == 1 && abs(from_y - to_y) == 2);
        }

        char piece_representation() const override {
            return color == Color::WHITE ? 'N' : 'n';
        }
    };

    ChessBoard() {
        squares.resize(8);
        for (auto &column : squares) {
            column.resize(8);
        }
    }

    std::vector<std::vector<std::unique_ptr<Piece>>> squares;

   MoveStatus move_piece(const std::string &from, const std::string &to);
};

#endif // CHESSBOARD_H
