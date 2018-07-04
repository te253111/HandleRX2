package com.example.kanokk.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BookModel implements Parcelable {
    private String userId;
    private String id;
    private String title;
    private String body;

    protected BookModel(Parcel in) {
        userId = in.readString();
        id = in.readString();
        title = in.readString();
        body = in.readString();
    }

    public static final Creator<BookModel> CREATOR = new Creator<BookModel>() {
        @Override
        public BookModel createFromParcel(Parcel in) {
            return new BookModel(in);
        }

        @Override
        public BookModel[] newArray(int size) {
            return new BookModel[size];
        }
    };

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(userId);
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(body);
    }
}
