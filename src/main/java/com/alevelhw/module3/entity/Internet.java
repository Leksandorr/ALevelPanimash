package com.alevelhw.module3.entity;

import lombok.*;

import javax.persistence.Entity;
import java.math.BigDecimal;

@ToString(callSuper = true)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Internet extends Activity {

    protected BigDecimal traffic;

    protected String ip;
}
