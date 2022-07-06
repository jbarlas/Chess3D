"""Board Logic"""

from FEN import FEN

DEFAULT = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"


class Board():
    def __init__(self, position:FEN=FEN(DEFAULT)):
        self._position = position
