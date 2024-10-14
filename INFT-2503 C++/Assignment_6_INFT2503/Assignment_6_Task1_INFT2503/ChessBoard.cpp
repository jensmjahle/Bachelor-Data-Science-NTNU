#include "ChessBoard.h"
#include <iostream>
#include <memory>
#include <vector>
#include <string>

// Implementing the move_piece function
ChessBoard::MoveStatus ChessBoard::move_piece(const std::string &from, const std::string &to) {
    int from_x = from[0] - 'a';
    int from_y = stoi(std::string() + from[1]) - 1;
    int to_x = to[0] - 'a';
    int to_y = stoi(std::string() + to[1]) - 1;

    auto &piece_from = squares[from_x][from_y];
    if (piece_from) {
        if (piece_from->valid_move(from_x, from_y, to_x, to_y)) {
            //std::cout << piece_from->type() << " is moving from " << from << " to " << to << std::endl;
            auto &piece_to = squares[to_x][to_y];
            if (piece_to) {
                if (piece_from->color != piece_to->color) {
                    //std::cout << piece_to->type() << " is being removed from " << to << std::endl;
                    if (auto king = dynamic_cast<King *>(piece_to.get())) {
                        if (king->color == Color::WHITE) {
                            return MoveStatus::BLACK_WIN;
                        } else {
                            return MoveStatus::WHITE_WIN;
                        }
                    }
                } else {
                    return MoveStatus::INVALID_MOVE;
                }
            }
            piece_to = std::move(piece_from);
            return MoveStatus::SUCCESS;
        } else {
            return MoveStatus::INVALID_MOVE;
        }
    } else {
        return MoveStatus::NO_PIECE;
    }
}
