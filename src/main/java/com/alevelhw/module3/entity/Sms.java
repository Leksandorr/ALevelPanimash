package com.alevelhw.module3.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sms extends Activity {

    @NonNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "receiver_id")
    protected Subscriber receiver;

    @Column(name = "content_sms")
    protected String contentSms;

    @Override
    public String toString() {
        return "Sms{" +
                "id=" + id +
                ", sender=" + sender +
                ", equipment=" + equipment.id +
                ", receiver=" + receiver.id +
                ", contentSms='" + contentSms + '\'' +
                '}';
    }
}
