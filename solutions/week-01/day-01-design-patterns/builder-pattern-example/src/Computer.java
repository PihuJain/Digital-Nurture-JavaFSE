// builder pattern
// Computer has a lot of parts and not all of them are required
// passing everything as constructor args means you lose track of which position is which
// builder lets you set only what you need and skip the rest

public class Computer {

    private String cpu;
    private String ram;
    private String storage;
    private String gpu;
    private boolean hasBluetooth;
    private boolean hasWifi;

    // private so the only way to create a Computer is through Builder
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.hasBluetooth = builder.hasBluetooth;
        this.hasWifi = builder.hasWifi;
    }

    public String toString() {
        return "cpu=" + cpu + " | ram=" + ram + " | storage=" + storage
             + " | gpu=" + gpu + " | bluetooth=" + hasBluetooth + " | wifi=" + hasWifi;
    }

    // static so you can do new Computer.Builder() before any Computer object exists
    public static class Builder {

        private String cpu;
        private String ram;

        // optional fields with defaults - caller only overrides what they need
        private String storage = "256gb ssd";
        private String gpu = "integrated";
        private boolean hasBluetooth = false;
        private boolean hasWifi = true;

        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        // each setter returns 'this' so calls can be chained one after another
        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder bluetooth(boolean val) {
            this.hasBluetooth = val;
            return this;
        }

        public Builder wifi(boolean val) {
            this.hasWifi = val;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
