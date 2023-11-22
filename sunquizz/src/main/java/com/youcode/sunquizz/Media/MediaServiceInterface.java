package com.youcode.sunquizz.Media;

import com.youcode.sunquizz.Media.DTOs.MediaReqDTO;
import com.youcode.sunquizz.Media.DTOs.MediaRespDTO;

import java.util.List;

public interface MediaServiceInterface {
    MediaRespDTO getMedia(Integer id);
    List<MediaRespDTO> getMedias();
    List<MediaRespDTO> getMediaByType(MediaType type);
    MediaRespDTO createMedia(MediaReqDTO media);
    MediaRespDTO updateMedia(MediaReqDTO media,Integer id);
    Integer deleteMedia(Integer id);
}
