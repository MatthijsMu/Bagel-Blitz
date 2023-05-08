package model.basictypes;

public class Field {
    private int file;
    private int rank;

    public Field() {
        this.file = -1;
        this.rank = -1;
    }

    public Field(int file, int rank) {
        if (file < 0 || file > 7 || rank < 0 || rank > 7) {
            throw new IllegalArgumentException("file and rank must be between 0 and 7");
        }
        this.file = file;
        this.rank = rank;
    }

    public boolean isValid() {
        return file >= 0 || file <= 7 || rank >= 0 || rank <= 7;
    }

    public int getfile() {
        if (!isValid()) {
            throw new IllegalStateException("Invalid field has no file");
        }
        return this.file;
    }

    public int getRank() {
        if (!isValid()) {
            throw new IllegalStateException("Invalid field has no rank");
        }
        return this.rank;
    }

    public Field shift(Direction direction) {
        if(!isValid()) {
            throw new IllegalStateException("Invalid field cannot be shifted")
        }
        int newFile = this.file + direction.getdFile();
        int newRank = this.rank + direction.getdRank();
        if (file < 0 || file > 7 || rank < 0 || rank > 7) {
            return new Field();
        }
        else return new Field(newFile, newRank);
    }
}

