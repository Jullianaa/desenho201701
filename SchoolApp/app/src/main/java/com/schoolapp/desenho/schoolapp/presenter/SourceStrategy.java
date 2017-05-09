package com.schoolapp.desenho.schoolapp.presenter;


import com.schoolapp.desenho.schoolapp.models.Exam;

import java.util.List;

public interface SourceStrategy {
    public List<Exam> search();
}
