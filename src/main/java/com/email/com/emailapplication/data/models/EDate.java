package com.email.com.emailapplication.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class EDate {
    @Id
    private long id;
    @NonNull
    private int day;
    @NonNull
    private String month;
    @NonNull
    private String year;

}
