"""Chess logic"""

from Board import Board
from Player import Player


class Chess():
    def __init__(self, board : Board, p1 : Player, p2 : Player):
        self._board = board
        self._p1 = p1
        self._p2 = p2


        
    
