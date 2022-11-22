package learn.lombok;

import lombok.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
@Getter
public class Category {
    @EqualsAndHashCode.Include
    @NonNull
    private int id;
    @Setter
    private String name;
}