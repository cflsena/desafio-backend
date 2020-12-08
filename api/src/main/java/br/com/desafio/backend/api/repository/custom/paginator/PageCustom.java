package br.com.desafio.backend.api.repository.custom.paginator;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class PageCustom extends PaginationCustom {
    private static final long serialVersionUID = -5447210726249171677L;
    private List<?> listObject;
}
