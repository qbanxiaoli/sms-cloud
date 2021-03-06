package com.dao.querydsl.Impl;

import com.dao.querydsl.SmsDao;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Q版小李
 * @description
 * @create 2018/8/16 10:33
 */
@Component
public class SmsDaoImpl implements SmsDao {

    private JPAQueryFactory queryFactory;

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public SmsDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostConstruct
    public void init() {
        queryFactory = new JPAQueryFactory(entityManager);
    }

    /**
     * @param smsFormDTO 短信请求数据传输类
     * @return Template 短信模版
     * @author qbanxiaoli
     * @description 查询短信模版
     */
//    @Override
//    public Template findSmsTemplate(SmsFormDTO smsFormDTO) {
//        //添加查询条件
//        Predicate predicate = QTemplate.template.type.eq(smsFormDTO.getType());
//        //查询短信模板
//        JPAQuery<Template> jpaQuery = queryFactory.select(QTemplate.template)
//                .from(QInformation.information)
//                .innerJoin(QTemplate.template)
//                .on(QInformation.information.id.intValue().eq(QTemplate.template.informationId.intValue()))
//                .where(predicate);
//        //拿到结果
//        return jpaQuery.fetchOne();
//    }

}
