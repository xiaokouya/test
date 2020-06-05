package com.kuang.blog.pojo;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author me 赵
 * @since 2020-06-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TRolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer roleId;

    private Integer permissionId;


}
