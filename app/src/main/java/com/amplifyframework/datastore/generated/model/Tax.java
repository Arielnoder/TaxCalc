package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Tax type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Taxes", type = Model.Type.USER, version = 1)
public final class Tax implements Model {
  public static final QueryField ID = field("Tax", "id");
  public static final QueryField FEDERAL = field("Tax", "federal");
  public static final QueryField STATE = field("Tax", "state");
  public static final QueryField TOTAL = field("Tax", "total");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="Float", isRequired = true) Double federal;
  private final @ModelField(targetType="Float", isRequired = true) Double state;
  private final @ModelField(targetType="Float", isRequired = true) Double total;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public Double getFederal() {
      return federal;
  }
  
  public Double getState() {
      return state;
  }
  
  public Double getTotal() {
      return total;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Tax(String id, Double federal, Double state, Double total) {
    this.id = id;
    this.federal = federal;
    this.state = state;
    this.total = total;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Tax tax = (Tax) obj;
      return ObjectsCompat.equals(getId(), tax.getId()) &&
              ObjectsCompat.equals(getFederal(), tax.getFederal()) &&
              ObjectsCompat.equals(getState(), tax.getState()) &&
              ObjectsCompat.equals(getTotal(), tax.getTotal()) &&
              ObjectsCompat.equals(getCreatedAt(), tax.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), tax.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getFederal())
      .append(getState())
      .append(getTotal())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Tax {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("federal=" + String.valueOf(getFederal()) + ", ")
      .append("state=" + String.valueOf(getState()) + ", ")
      .append("total=" + String.valueOf(getTotal()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static FederalStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Tax justId(String id) {
    return new Tax(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      federal,
      state,
      total);
  }
  public interface FederalStep {
    StateStep federal(Double federal);
  }
  

  public interface StateStep {
    TotalStep state(Double state);
  }
  

  public interface TotalStep {
    BuildStep total(Double total);
  }
  

  public interface BuildStep {
    Tax build();
    BuildStep id(String id);
  }
  

  public static class Builder implements FederalStep, StateStep, TotalStep, BuildStep {
    private String id;
    private Double federal;
    private Double state;
    private Double total;
    @Override
     public Tax build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Tax(
          id,
          federal,
          state,
          total);
    }
    
    @Override
     public StateStep federal(Double federal) {
        Objects.requireNonNull(federal);
        this.federal = federal;
        return this;
    }
    
    @Override
     public TotalStep state(Double state) {
        Objects.requireNonNull(state);
        this.state = state;
        return this;
    }
    
    @Override
     public BuildStep total(Double total) {
        Objects.requireNonNull(total);
        this.total = total;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, Double federal, Double state, Double total) {
      super.id(id);
      super.federal(federal)
        .state(state)
        .total(total);
    }
    
    @Override
     public CopyOfBuilder federal(Double federal) {
      return (CopyOfBuilder) super.federal(federal);
    }
    
    @Override
     public CopyOfBuilder state(Double state) {
      return (CopyOfBuilder) super.state(state);
    }
    
    @Override
     public CopyOfBuilder total(Double total) {
      return (CopyOfBuilder) super.total(total);
    }
  }
  
}
