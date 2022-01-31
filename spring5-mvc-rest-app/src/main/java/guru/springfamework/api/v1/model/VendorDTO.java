package guru.springfamework.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDTO {

    @ApiModelProperty(value = "This is the name of the Vendor", required = true)
    private String name;
    @ApiModelProperty(value = "This is the given URL for a Vendor", required = true)
    private String vendor_url;
}
