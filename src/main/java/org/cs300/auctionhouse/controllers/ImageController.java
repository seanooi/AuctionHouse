package org.cs300.auctionhouse.controllers;

import org.cs300.auctionhouse.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImageController
{
    /**
     * Provides access to the picture factory business functionality
     */
    @Autowired
    private Services services;

    /**
     * Returns the byte[] that contains the requested image
     *
     * @param id            The identifier of the image
     *
     * @return              A byte[] that contains the requested image
     */
    @RequestMapping( value = "/image", method = RequestMethod.GET )
    @ResponseBody
    public byte[] getPicture(@RequestParam("id") int id)
    {
        return services.getAuctionImage(id);
    }
}
