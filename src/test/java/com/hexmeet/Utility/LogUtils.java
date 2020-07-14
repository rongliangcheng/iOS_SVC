package com.hexmeet.Utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author raleigh
 * @create 2020-06-19
 */
public class LogUtils {


        public LogUtils() {
        }

        public static String base64ImageHtml(String base64Image) {
            return String.format("<img src=\"data:image/png;base64,%1$s\"/>", base64Image);
        }

        public static String imageHtml(String imagePath) {
            return String.format("<img style='width: 15%%' onerror='this.style.display=\"none\"' data-featherlight='%s' src='%s' data-src='%s'>", imagePath, imagePath, imagePath);
        }
}
