package com.t3h.areadata

import android.transition.ChangeBounds
import android.transition.ChangeImageTransform
import android.transition.ChangeTransform
import android.transition.TransitionSet
import android.view.animation.TranslateAnimation

class DetailsTransition :TransitionSet {
    constructor(){
        setOrdering(ORDERING_TOGETHER);
        addTransition( ChangeBounds()).
        addTransition( ChangeTransform()).
        addTransition( ChangeImageTransform())
    }
}