package com.youcode.sunquizz.domains.Media;

import com.youcode.sunquizz.domains.Media.DTOs.MediaReqDTO;
import com.youcode.sunquizz.domains.Media.DTOs.MediaRespDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MediaService implements MediaServiceInterface{
    MediaRepository mediaRepository;
    ModelMapper modelMapper;

    //get one media
    public MediaRespDTO getMedia(Integer id)
    {
        Optional<Media> media = mediaRepository.findById(id);
        return modelMapper.map(media.orElse(null),MediaRespDTO.class);
    }

    //get all medias
    public Page<MediaRespDTO> getMedias(Pageable pageable)
    {
        Page<Media> entityPage = mediaRepository.findAll(pageable);
        return entityPage.map(entity -> modelMapper.map(entity, MediaRespDTO.class));
    }

    // get all media by his type
    public List<MediaRespDTO> getMediaByType(MediaType type)
    {
        return mediaRepository.findAllByType(type)
                .stream()
                .map(media -> modelMapper.map(media,MediaRespDTO.class))
                .collect(Collectors.toList());
    }

    //create media
    public MediaRespDTO createMedia(MediaReqDTO media)
    {
        return modelMapper.map(
                mediaRepository
                .save(modelMapper.map(media,Media.class)),
                MediaRespDTO.class
        );
    }

    //update media
    public MediaRespDTO updateMedia(MediaReqDTO media,Integer id)
    {
        Optional<Media> existMedia = mediaRepository.findById(id);
        return existMedia.map(media1 -> {
            media.setId(media1.getId());
            return modelMapper.map(
                    mediaRepository
                            .save(modelMapper.map(media,Media.class)),
                    MediaRespDTO.class
            );
        }).orElse(null);
    }

    //delete media
    public Integer deleteMedia(Integer id)
    {
        Optional<Media> media = mediaRepository.findById(id);
        return media.map(media1 -> {
            mediaRepository.delete(media1);
            return 1;
        }).orElse(0);
    }
}
