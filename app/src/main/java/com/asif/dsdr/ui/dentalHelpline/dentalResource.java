package com.asif.dsdr.ui.dentalHelpline;

/**
 * Created by Asif on 17-Apr-20
 */
class dentalResource {
    private int imageR1;
    private int imageR2;
    private String Text1;
    private String Text2;

    dentalResource(int imageR1, int imageR2, String Text1, String Text2) {
        this.imageR1 = imageR1;
        this.imageR2 = imageR2;
        this.Text1 = Text1;
        this.Text2 = Text2;
    }

    int getImageR1() {
        return imageR1;
    }

    int getImageR2() {
        return imageR2;
    }

    String getText1() {
        return Text1;
    }

    String getText2() {
        return Text2;
    }
}
