package com.candenizgumus.entity;

import com.candenizgumus.entity.enums.ECinsiyet;
import com.candenizgumus.entity.enums.EStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tblauth")
public class Auth
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @CreationTimestamp
    Long createAt;
    @UpdateTimestamp
    Long updateAt;
    @Builder.Default
    EStatus status = EStatus.ACTIVE;


    String ad;
    String soyad;
    String email;
    String telefon;
    String sifre;
    Long dogumTarihi;
    @Enumerated(EnumType.STRING)
    ECinsiyet cinsiyet;
}