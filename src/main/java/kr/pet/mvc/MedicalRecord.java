package kr.pet.mvc;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecord {
    private String phoneNumber;
    private String date;
    private String content;


}
