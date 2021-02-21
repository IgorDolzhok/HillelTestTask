package Main;


import java.util.ArrayList;
import java.util.List;
        public class Task12 {
        private static class Ball {
        }
        private static class Board {
            private List<Ball> balls = new ArrayList<>();
            public Board() {
                List<Ball> balls = new ArrayList<>();
                balls.add(new Ball());
                balls.add(new Ball());
                balls.add(new Ball());
            }
            public int count() {
                return balls.size();
            }
        }
        public static void main(String[] args) {
            Board board = new Board();
            System.out.println(board.count());
        }
    }

