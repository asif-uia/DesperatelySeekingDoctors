package com.asif.dsdr.ui.coronaHotline;

/**
 * Created by Asif on 20-Apr-20
 */
public class hotlineResource {
    private int imageR1;
    private String Text1;
    private String Text2;

    public hotlineResource(int imageR1, String Text1, String Text2) {
        this.imageR1 = imageR1;
        this.Text1 = Text1;
        this.Text2 = Text2;
    }

    public int getImageR1() {
        return imageR1;
    }

    public String getText1() {
        return Text1;
    }

    public String getText2() {
        return Text2;
    }
}
