package com.asif.dsdr.ui.coronaHotline;

/**
 * Created by Asif on 20-Apr-20
 */
class hotlineResource {
    private String Text1;
    private String Text2;

    hotlineResource(String Text1, String Text2) {
        this.Text1 = Text1;
        this.Text2 = Text2;
    }

    String getText1() {
        return Text1;
    }

    String getText2() {
        return Text2;
    }
}
