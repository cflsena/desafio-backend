package br.com.desafio.backend.api.repository.custom.paginator;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaginationCustom implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer pageIndex;
    private Integer pageSize;
    private Integer length;

}
