package com.example.AirBnbApp.service;

import com.example.AirBnbApp.dto.*;
import com.example.AirBnbApp.entity.Room;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelPriceResponseDto> searchHotels(HotelSearchRequest hotelSearchRequest);

    List<InventoryDto> getAllInventoryByRoom(Long roomId);

    void updateInventory(Long roomId, UpdateInventoryRequestDto updateInventoryRequestDto);
}


//public interface InventoryService {
//
//    void initializeRoomForYear(Room room);
//
//    void initializeRoomForAYear(Room room);
//
//    void deleteAllInventories(Room room);
//
//    Page<HotelDto> searchHotels(HotelSearchRequest hotelSearchRequest);
//
//    List<InventoryDto> getAllInventoryByRoom(Long roomId);
//
//     void updateInventory(Long roomId, UpdateInventoryRequestDto updateInventoryRequestDto);
//
//}
