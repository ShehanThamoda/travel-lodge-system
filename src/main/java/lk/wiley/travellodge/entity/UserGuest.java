package lk.wiley.travellodge.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author shehan
 * @des The persistent class for the UserGuest database table.
 *
 */
@Entity
@Table(name="user_guest")
@NamedQuery(name="UserGuest.findAll", query="SELECT u FROM UserGuest u")
@Data
@NoArgsConstructor
public class UserGuest {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private int id;

    @Column(name="display_name", nullable=false, length=255)
    private String displayName;

    @Column(nullable=false, length=255)
    private String username;

    @Column(nullable=false, length=255)
    private String password;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="updated_at")
    private Timestamp updatedAt;

    @Column(name="first_name", nullable=false, length=100)
    private String firstName;

    @Column(name="last_name", nullable=false, length=100)
    private String lastName;

    @Column(name="email", nullable=false, length=100)
    private String email;

    @Column(name="phone_number", nullable=false, length=20)
    private String phoneNumber;

    @Column(name="profile_picture")
    private byte[] profilePicture;

    public UserGuest(int id) {
        this.id = id;
    }
}
