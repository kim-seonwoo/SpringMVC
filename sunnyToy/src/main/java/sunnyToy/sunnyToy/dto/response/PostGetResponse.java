package sunnyToy.sunnyToy.dto.response;

import sunnyToy.sunnyToy.domain.entity.*;

public record PostGetResponse(
        Long id,
        String title,
        String content
        ) {
    public static PostGetResponse of(Post post) {
        return new PostGetResponse(
                post.getPostId(),
                post.getTitle(),
                post.getContent()
                );
    }
}
