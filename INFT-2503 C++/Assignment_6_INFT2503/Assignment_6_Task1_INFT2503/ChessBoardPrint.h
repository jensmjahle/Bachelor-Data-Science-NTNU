#ifndef CHESSBOARDPRINT_H
#define CHESSBOARDPRINT_H
#include <string>
#include "ChessBoard.h"


class ChessBoard;

class ChessBoardPrint {
public:
    explicit ChessBoardPrint(ChessBoard &board);
    void print_board() const;
    void print_move(const std::string &from, const std::string &to, ChessBoard::MoveStatus result) const;

private:
    ChessBoard &board;



};



#endif //CHESSBOARDPRINT_H
