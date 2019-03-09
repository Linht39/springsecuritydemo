package edu.tust.springsecuritydemo.entity;

/**
 * Created by IntelliJ IDEA.
 * User: Linht
 * Date: 2019/3/7
 * Time: 13:46
 */
public class SysRole {

    private Long id;
    private String roleName;

    public SysRole(String roleName) {
        this.roleName = roleName;
    }

    public SysRole(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
