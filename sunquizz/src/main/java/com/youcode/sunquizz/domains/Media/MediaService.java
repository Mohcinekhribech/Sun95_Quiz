package com.youcode.sunquizz.domains.Media;

import com.youcode.sunquizz.domains.Media.DTOs.MediaReqDTO;
import com.youcode.sunquizz.domains.Media.DTOs.MediaRespDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MediaService implements MediaServiceInterface{
    MediaRepository mediaRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    public MediaService(MediaRepository mediaRepository)
    {
        this.mediaRepository = mediaRepository;
    }
    public MediaRespDTO getMedia(Integer id)
    {
        Optional<Media> media = mediaRepository.findById(id);
        return modelMapper.map(media.orElse(null),MediaRespDTO.class);
    }
    public Page<MediaRespDTO> getMedias(Pageable pageable)
    {
        Page<Media> entityPage = mediaRepository.findAll(pageable);
        return entityPage.map(entity -> modelMapper.map(entity, MediaRespDTO.class));
    }
    public List<MediaRespDTO> getMediaByType(MediaType type)
    {
        return mediaRepository.findAllByType(type)
                .stream()
                .map(media -> modelMapper.map(media,MediaRespDTO.class))
                .collect(Collectors.toList());
    }
    public MediaRespDTO createMedia(MediaReqDTO media)
    {
        return modelMapper.map(
                mediaRepository
                .save(modelMapper.map(media,Media.class)),
                MediaRespDTO.class
        );
    }
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
    public Integer deleteMedia(Integer id)
    {
        Optional<Media> media = mediaRepository.findById(id);
        return media.map(media1 -> {
            mediaRepository.delete(media1);
            return 1;
        }).orElse(0);
    }
}
