package appLaunchTwo.Test;

import java.io.File;
import java.io.FilenameFilter;

public class OnlyExt implements FilenameFilter {
   private String ext;

    public OnlyExt(String ext) {
        this.ext = "."+ext;
    }
    public OnlyExt() {

    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(ext);
    }
}
