"""Board Logic"""

from FEN import FEN

class Board():
    def __init__(self, position=FEN(DEFAULT)):
        self._position = position
