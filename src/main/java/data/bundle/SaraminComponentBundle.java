/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  data.bundle.SaraminComponentBundle
 *  data.dao.ApiRepository
 *  data.dao.UIDataLabelRepository
 *  org.springframework.stereotype.Component
 */
package data.bundle;

import data.dao.ApiRepository;
import data.dao.UIDataLabelRepository;
import org.springframework.stereotype.Component;

@Component
public class SaraminComponentBundle {
    public final ApiRepository apiRepository;
    public final UIDataLabelRepository uiRepository;

    public SaraminComponentBundle(ApiRepository apiRepository, UIDataLabelRepository uiRepository) {
        this.apiRepository = apiRepository;
        this.uiRepository = uiRepository;
    }
}

