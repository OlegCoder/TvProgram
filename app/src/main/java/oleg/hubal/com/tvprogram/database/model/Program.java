package oleg.hubal.com.tvprogram.database.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by User on 11.09.2016.
 */
public class Program implements Parcelable {

    private long date;
    private String day;
    private String channelName;
    private String showName;

    public Program() {

    }

    public Program(String day, long date, String channelName, String showName) {
        this.day = day;
        this.date = date;
        this.channelName = channelName;
        this.showName = showName;
    }

    public Program(Parcel in) {
        String[] data = new String[4];

        in.readStringArray(data);
        this.date = Long.getLong(data[0]);
        this.day = data[1];
        this.channelName = data[2];
        this.showName = data[3];
    }

    @Override
    public String toString() {
        return  "\nname: " + channelName +
                "\ndate: " + date +
                "\nshowName " + showName +
                "\n";
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {String.valueOf(this.date),
                                                            this.day,
                                                            this.channelName,
                                                            this.showName});
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Program createFromParcel(Parcel in) {
            return new Program(in);
        }

        public Program[] newArray(int size) {
            return new Program[size];
        }
    };
}
