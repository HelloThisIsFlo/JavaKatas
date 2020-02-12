package katas.marsrover;

abstract class FacingDirection {

    abstract FacingDirection turnLeft();

    abstract FacingDirection turnRight();

    abstract void moveForward(WrappingCoordinates coordinatesToModify);

    static class FacingNorth extends FacingDirection {
        @Override
        FacingDirection turnLeft() {
            return new FacingWest();
        }

        @Override
        FacingDirection turnRight() {
            return new FacingEast();
        }

        @Override
        void moveForward(WrappingCoordinates coordinatesToModify) {
            coordinatesToModify.setY(coordinatesToModify.getY() + 1);
        }

        @Override
        public String toString() {
            return "N";
        }
    }

    static class FacingSouth extends FacingDirection {
        @Override
        FacingDirection turnLeft() {
            return new FacingEast();
        }

        @Override
        FacingDirection turnRight() {
            return new FacingWest();
        }

        @Override
        void moveForward(WrappingCoordinates coordinatesToModify) {
            coordinatesToModify.setY(coordinatesToModify.getY() - 1);
        }

        @Override
        public String toString() {
            return "S";
        }
    }

    static class FacingEast extends FacingDirection {
        @Override
        FacingDirection turnLeft() {
            return new FacingNorth();
        }

        @Override
        FacingDirection turnRight() {
            return new FacingSouth();
        }

        @Override
        void moveForward(WrappingCoordinates coordinatesToModify) {
            coordinatesToModify.setX(coordinatesToModify.getX() + 1);
        }

        @Override
        public String toString() {
            return "E";
        }
    }

    static class FacingWest extends FacingDirection {
        @Override
        FacingDirection turnLeft() {
            return new FacingSouth();
        }

        @Override
        FacingDirection turnRight() {
            return new FacingNorth();
        }

        @Override
        void moveForward(WrappingCoordinates coordinatesToModify) {
            coordinatesToModify.setX(coordinatesToModify.getX() - 1);
        }

        @Override
        public String toString() {
            return "W";
        }
    }
}
