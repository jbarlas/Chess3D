"""Forsyth-Edwards Notation"""

class FEN():
    def __init__(self, position):
        pos, active, castle, en_passant, half, full = self.extract_pos(position)
        self.pos = pos.split("/")
        self.active = active
        self.castle = castle
        self.en_passant = en_passant
        self.half = int(half)
        self.full = int(full)

    def extract_pos(self, position):
        pos, active, castle, en_passant, half, full = position.split()
        if not (pos or active or castle or en_passant or half or full):
            raise ValueError("Invalid FEN formatting")
        else:
            return pos, active, castle, en_passant, half, full