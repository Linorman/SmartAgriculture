package com.sm.smartagriculture.server.constant;

/**
 * 权限编码
 * @author linorman
 * @date 2020/7/15 10:45
 */
public enum PermissionCode {
    /**
     * 默认权限
     */
    USER("基本权限",15),

    /**
     * 控制权限
     */
    CONTROL("控制权限",20),

    /**
     * 修改权限
     */
    MODIFY("修改权限",30);

    private final String permission;
    private final int value;

    PermissionCode(String permission, int value) {
        this.permission = permission;
        this.value = value;
    }

    public String getPermission() {
        return permission;
    }

    public int getValue() {
        return value;
    }

    public static PermissionCode getPermissionCode(int value) {
        for (PermissionCode permissionCode : PermissionCode.values()) {
            if (permissionCode.getValue() == value) {
                return permissionCode;
            }
        }
        return null;
    }

    public static PermissionCode getPermissionCode(String permission) {
        for (PermissionCode permissionCode : PermissionCode.values()) {
            if (permissionCode.getPermission().equals(permission)) {
                return permissionCode;
            }
        }
        return null;
    }


}
