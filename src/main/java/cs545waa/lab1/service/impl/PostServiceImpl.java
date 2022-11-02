package cs545waa.lab1.service.impl;

import cs545waa.lab1.domain.Post;
import cs545waa.lab1.domain.dto.PostDto;
import cs545waa.lab1.helper.ListMapper;
import cs545waa.lab1.repository.PostRepo;
import cs545waa.lab1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final  PostRepo postRepo;

     @Autowired
     ModelMapper modelMapper;

    @Autowired
    ListMapper<Post,PostDto> listMapperPostToDto;


    @Override
    public List<PostDto> getAllPosts() {
        return  (List<PostDto> ) listMapperPostToDto.mapList(postRepo.findAll(),new PostDto());

    }

    @Override
    public PostDto getById(long id) {
        return modelMapper.map(postRepo.getById(id),PostDto.class)  ;
    }

    @Override
    public void save(PostDto p) {
    postRepo.save(modelMapper.map(p,Post.class));
    }

    @Override
    public void delete(int id) {
        postRepo.delete(id);

    }


    @Override
    public void update(int id, PostDto p) {
    postRepo.update(id,modelMapper.map(p,Post.class));
    }
}
