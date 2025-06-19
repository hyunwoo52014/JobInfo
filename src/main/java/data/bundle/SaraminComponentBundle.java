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
import data.dao.UISaraminDataLabelRepository;

import org.springframework.stereotype.Component;

@Component
public class SaraminComponentBundle {
    public final ApiRepository apiRepository;
    public final UISaraminDataLabelRepository uiRepository;

    public SaraminComponentBundle(ApiRepository apiRepository, UISaraminDataLabelRepository uiRepository) {
        this.apiRepository = apiRepository;
        this.uiRepository = uiRepository;
    }
}

