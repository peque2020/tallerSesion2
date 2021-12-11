package devices;

public class FactoryDevices {

    public enum DevicesType{
        ANDROID,
        IOS,
        WINDOWPHONE,
        CLOUD
    }

    public static IDevice make(DevicesType type){
        IDevice device;
        switch (type){
            case ANDROID:
                device= new Android();
                break;
            case IOS:
                device= new IOS();
                break;
            case WINDOWPHONE:
                device= new WindowsPhone();
                break;
            case CLOUD:
                device= new AndroidCloud();
                break;
            default:
                device= new Android();
                break;
        }
        return device;
    }
}
