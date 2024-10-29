package sunnyToy.sunnyToy.service;

import jakarta.persistence.*;
import jakarta.transaction.*;
import lombok.*;
import org.springframework.stereotype.*;
import sunnyToy.sunnyToy.common.request.*;
import sunnyToy.sunnyToy.domain.entity.*;
import sunnyToy.sunnyToy.dto.request.*;
import sunnyToy.sunnyToy.dto.response.*;
import sunnyToy.sunnyToy.repository.*;

import java.awt.*;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional()
public class PostService {

    private final PostJpaRepository postJpaRepository;
    private final MemberJpaRepository memberJpaRepository;


    @Transactional
    public String create(PostCreateRequest request, Long memberId) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        Post post = postJpaRepository.save(
                Post.builder()
                        .member(member)
                        .title(request.title())
                        .content(request.content()).build());
        return post.getPostId().toString();
    }

    @Transactional
    public void editContent(Long postId, PostUpdateRequest request) {
        Post post = postJpaRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
//        post.updateContent(request.content());
    }

    @Transactional
    public void deleteById(Long postId) {
        Post post = postJpaRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
        postJpaRepository.delete(post);
    }

    public List<PostGetResponse> getPosts(Long memberId) {
        return postJpaRepository.findAllByMemberId(memberId)
                .stream()
                .map(post -> PostGetResponse.of(post))
                .toList();
    }

    public PostGetResponse getById(Long postId) {
        Post post = postJpaRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
        return PostGetResponse.of(post);
    }
}
