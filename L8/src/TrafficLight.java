import java.awt.Color;

public enum TrafficLight {
    RED(Color.RED) {
        //implement abstract method
        @Override
        public TrafficLight next() {
            return GREEN;
        } 
    }, 
    YELLOW(Color.YELLOW) {
        @Override
        public TrafficLight next() {
            return RED;
        }
        
    }, 
    GREEN(Color.GREEN) {
        @Override
        public TrafficLight next() {
            return YELLOW;
        }
        
    };

    private final Color color;
    
    private TrafficLight(Color color) {
        this.color = color;
    }

    public abstract TrafficLight next();
    
    public Color getColor() {
        return color;
    }
}
