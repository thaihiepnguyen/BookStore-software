package Business.UserBU;

import DataAccess.PromotionDA;
import Pojo.PromotionPOJO;

import java.util.List;

public class PromotionBU {
    public List<PromotionPOJO>[] getAll(){
        return new List[]{PromotionDA.getAll()};
    }
    public List<PromotionPOJO>[] getPastPromotions(){
        return new List[]{PromotionDA.getPastPromotions()};
    }
    public List<PromotionPOJO>[] getCurrentPromotions(){
        return new List[]{PromotionDA.getCurrentPromotions()};
    }
    public List<PromotionPOJO>[] getUpComingPromotions(){
        return new List[]{PromotionDA.getUpComingPromotions()};
    }
    public List<PromotionPOJO>[] searchPromotion(String title){
        return new List[]{PromotionDA.searchPromotion(title)};
    }

}
