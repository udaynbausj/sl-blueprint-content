package io.blueprint.content.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class RegionModel {
    @Id
    @GeneratedValue
    var id: Int = 0
    var pinCode: Int = 0
    var city: String = ""
    var country: String = ""
}
