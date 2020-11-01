package com.reinmind.entity;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author zx
 */
@Component
public interface Knight {
    /**
     * 行动
     */
    String action();
}
