//
// Created by jmjahle on 10.10.24.
//

#include "ChessBoardPrint.h"

#include <iostream>
#include "ChessBoard.h"

using namespace std;

ChessBoardPrint::ChessBoardPrint(ChessBoard &board) : board(board) {}

/// Prints the board
void ChessBoardPrint::print_board() const {

    const auto &squares = board.squares;
    cout << "  a b c d e f g h" << endl; // Column labels
    for (int y = 7; y >= 0; --y) {
        cout << y + 1 << " "; // Row labels
        for (int x = 0; x < 8; ++x) {
            if (squares[x][y]) {
                cout << squares[x][y]->piece_representation() << " ";
            } else {
                cout << ". "; // Empty square
            }
        }
        cout << y + 1 << endl; // Row labels
    }
    cout << "  a b c d e f g h" << endl; // Column labels
}

void ChessBoardPrint::print_move(const std::string &from, const std::string &to, ChessBoard::MoveStatus result) const {
    switch (result) {
        case ChessBoard::MoveStatus::SUCCESS:
            std::cout << "Move from " << from << " to " << to << " was successful." << std::endl;
        break;
        case ChessBoard::MoveStatus::INVALID_MOVE:
            std::cout << "Invalid move from " << from << " to " << to << ": the piece cannot move that way." << std::endl;
        break;
        case ChessBoard::MoveStatus::NO_PIECE:
            std::cout << "No piece at " << from << " to move." << std::endl;
        break;
        case ChessBoard::MoveStatus::WHITE_WIN:

            std::cout << "Game over! White wins" << std::endl;
        break;
        case ChessBoard::MoveStatus::BLACK_WIN:
            std::cout << "Game over! Black wins" << std::endl;
        break;
    }
}