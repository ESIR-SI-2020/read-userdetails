package fr.esir.jxc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;
    private String username;
    private String password;
    private String email;
    private String photoUrl;
    private String bio;
    private Address address;
    private List<String> friendsId;




}