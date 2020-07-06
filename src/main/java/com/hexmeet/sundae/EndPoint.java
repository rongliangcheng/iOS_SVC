package com.hexmeet.sundae;

import com.hexmeet.sundae.mediaStatistics.CALLTYPE;
import com.hexmeet.sundae.mediaStatistics.MediaStatistics;

public interface EndPoint<T extends EndPoint<T>> extends SUT {

    String getDialString(CALLTYPE callType);

    T placeCall(EndPoint<?> callee, CALLTYPE callType, int callRate);
    T placeCall(String dialString, CALLTYPE callType, int callRate);

    MediaStatistics getMediaStatistics();

}
